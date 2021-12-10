package org.academiadecodigo.bootcamp65;

import org.academiadecodigo.bootcamp65.model.Place;
import org.academiadecodigo.bootcamp65.services.PlaceService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) {

        String userPassword = "Lmaokai";

        byte[] recievedPassword = userPassword.getBytes();
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] theMD5digest = md.digest(recievedPassword);

        System.out.println(md.digest(recievedPassword));
    }
}
