package com.packt.arapidhs;

public class DeclarationOrder {

    /**
     * <p>
     * Order static variables first
     *  <ul>
     *      <li>public</li>
     *      <li>protected</li>
     *      <li>no access</li>
     *      <li>private</li>
     *  </ul>
     * </p>
     */
    public static String FOO;
    protected  static String BAR;
    static String FOO_BAR;
    private static String BAR_FOO;

    /**
     * <p>Order instance variables.</p>
     */
    public String boo;
    protected  String far;
    String boo_far;
    private String far_boo;
    
    /** Default empty constructor. */
    public Foo(){
        //
    }
    
    /* Order static methods.*/
    
    public static void foo(){
        //
    }
    
    protected static void bar(){
        //
    }

    static void fooBar(){
        //
    }
    
    private static void barFoo(){
        //
    }
    
    /* Order instance methods.*/
    public void boo(){
        //
    }
    
    protected void far(){
        //
    }

    void booFar(){
        //
    }
    
    private void farBoo(){
        //
    }
}

