package com.nagel.decathlon;

import com.nagel.decathlon.app.DecathlonTournament;

/**
 * Application.
 * <p>
 * Date: 29/08/2020
 *
 * @author dfatkulin
 */
public class Application {

    public static void main(String[] args) {
        DecathlonTournament decathlonTournament = new DecathlonTournament();
        decathlonTournament.start();
    }
}
