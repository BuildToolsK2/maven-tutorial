package com.nexse.swat.tutorial.mvn;

public interface HashService {

    /**
     * Returns the hex representation of an md5 hash.
     *
     * @param input the input bytes
     * @return the hex representation of an md5 hash
     */
    String md5(String input);

}
