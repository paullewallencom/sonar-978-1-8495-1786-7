package com.schoox.impl;

import com.schoox.api.User;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class UserRecommender {

    private static UserRecommender instance;
    private static DataModel model;
    private static final FileUserCloudReader reader = 
            new FileUserCloudReader("/users/");
    
    protected UserRecommender() {
        // Exists only to defeat instantiation.
    }

    public static UserRecommender getInstance() throws IOException {
        if (instance == null) {
            instance = new UserRecommender();
            final String csv = "model.csv";
            model = new FileDataModel(new File(csv));
        }
        return instance;
    }

    public List<User> recommend(
            final long id, final int max) throws IOException {
        try {
        	
            final List<User> users = new ArrayList<User>();
            
            final GenericUserBasedRecommender recommender = getDefaultReccommender();
            
            
            for (long userId: recommender.mostSimilarUserIDs(id, max)){
                users.add(reader.read(userId));
            }
            
            return users;
            
        } catch (TasteException ex) {
            Logger.getLogger(UserRecommender.class.getName()).
                    log(Level.SEVERE, null, ex);
            throw new IOException(ex.getMessage(),ex);
        }
    }

	public GenericUserBasedRecommender getDefaultReccommender()
			throws TasteException {
		final UserSimilarity userSimilarity =
		        new LogLikelihoodSimilarity(model);
		final UserNeighborhood neighborhood =
		        new NearestNUserNeighborhood(5, userSimilarity, model);
		final GenericUserBasedRecommender recommender =
		        new GenericUserBasedRecommender(
		        model, neighborhood, userSimilarity);
		return recommender;
	}
	
    public static DataModel getModel(){
	    return model;
    }
    	
}

