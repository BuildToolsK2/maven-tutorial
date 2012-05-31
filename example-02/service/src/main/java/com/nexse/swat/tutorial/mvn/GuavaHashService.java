package com.nexse.swat.tutorial.mvn;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public class GuavaHashService implements HashService {

    private HashFunction hashFunction = Hashing.md5();

    /**
     * Returns the hex representation of an md5 hash.
     *
     * @param input the input bytes
     * @return the hex representation of an md5 hash
     */
    @Override
    public String md5(String input) {
        return hashFunction.newHasher().putBytes(input.getBytes()).hash().toString();
    }

}
