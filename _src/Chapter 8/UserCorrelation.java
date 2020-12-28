package com.schoox.impl;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class UserCorrelation extends UserRecommender {

	public GenericUserBasedRecommender getDefaultReccommender()
			throws TasteException {
		
		final UserSimilarity userSimilarity =
		        new PearsonCorrelationSimilarity(getModel());		
		final UserNeighborhood neighborhood =
		        new NearestNUserNeighborhood(2, userSimilarity, getModel());
		final GenericUserBasedRecommender recommender =
		        new GenericUserBasedRecommender(
		        		getModel(), neighborhood, userSimilarity);
		return recommender;
	}
	
}

