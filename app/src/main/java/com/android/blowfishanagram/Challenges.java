package com.android.blowfishanagram;

/**
 * Created by Leia on 10/15/2015.
 */
public class Challenges {
    private String[] challenges = {
            "tiuncao","naipt","moneldae","soumaf","nninrug","sktic","klbaent","yccible","mtioaeonl","uiatrg"
    };
    private String[] solutions = {
            "caution","paint","lemonade","famous","running","stick","blanket","bicycle","emotional","guitar"
    };
    private boolean[] isSolved = {
            false,false,false,false,false,false,false,false,false,false
            //true,true,true,true,true,true,true,true,true,true     //to test whether when they are all solved if it goes to the results page
    };
    /*
    @param index takes in the index for the challenge
    @return String returns the string of the challenge
     */
    public String getChallenge(int index){
        return challenges[index];
    }
    /*
    @param index takes in the index of the solution
    @return String returns the solution
     */
    public String getSolution(int index){
        return solutions[index];
    }
    /*
    @param index takes in the index of the solved challenge
     */
    public void setSolved(int index){
        isSolved[index]=true;
    }
    public boolean getSolved(int index) { return isSolved[index]; }




}
