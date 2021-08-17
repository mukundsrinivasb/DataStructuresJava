package Lab_2;

/**
 * The factory class which produces Vandral battalions according to the schema provided.
 * Please note that you may edit this class as much as you like (create helper methods if you want!). So long as you genuinely pass the tests.
 * Ask questions if you are lost or unsure!
 */
public class VandralBattalionFactory {
    /*
    Copy of schema:
        At easy difficulty:
        - For every even level, an additional muggle is spawned.
        - For every 20 Muggles, 3 Low-Archons or 1 High-Archon an additional healer is spawned.
        - For every 5 levels up until level 75 a Low-Archon is spawned.
        - Beyond level 75, every 5 levels a High-Archon is spawned.

        At hard difficulty:
        - All spawn rates, except for healers, are halved rounding down.
        - Note that you will still spawn Low-Archons up until 75 and then High-Archons.

        For examples, please look at the lab slides.
     */

    /**
     * Creates a battalion to fight against!
     *
     * @param difficulty  set by user
     * @param playerLevel level that player is currently at between 1 and 100 inclusive
     * @return a Vandral battalion according to the schema
     * @throws Exception if the player level is not within 1 and 100 inclusive
     */
    public static VandralBattalion createVandralBattalion(Difficulty difficulty, int playerLevel)
            throws Exception {

        // We have done the exception handling for you. :)
        if (playerLevel < 1 || playerLevel > 100) {
            throw new Exception("Player level out of bounds");
        }
        //The case of Easy difficulty
        //Number of even numbers from 1 to playerLevel = Muggles
        //Number of multiples of 5 from 1 to playerLevel until 75 = lowArchorns
        //Number of multiples of 5 from 76 to playerLevel = HighAchorns
        //Healers = Muggles/20 + LowAcorns/3 + HighAcorns
        if (difficulty.equals(Difficulty.EASY)) {
            int Muggles = (playerLevel / 2);
            int LowArchons = 0, HighArcons = 0;
            LowArchons = (playerLevel <= 75) ? playerLevel / 5 : 15;
            HighArcons = (playerLevel > 75) ? ((playerLevel - 75) / 5) : 0;
            int Healer = (Muggles / 20) + (LowArchons / 3) + (HighArcons);

            return new VandralBattalion(Muggles, Healer, LowArchons, HighArcons);
        }

        //The case of Hard difficulty
        //Number of Integers from 1 to playerLevel = Muggles
        //Number of multiples of 2 from 1 to playerLevel until 75 = lowArchorns
        //Number of multiples of 2 from 76 to playerLevel = HighAchorns
        //Healers = Muggles/20 + LowAcorns/3 + HighAcorns
        else {
            int Muggles = playerLevel;
            int LowArchons = 0, HighArcons = 0;
            LowArchons = (playerLevel <= 75) ? playerLevel / 2 : (75/2) ;
            HighArcons = (playerLevel > 75) ? ((playerLevel - 75) / 2) : 0;
            int Healer = (Muggles / 20) + (LowArchons / 3) + (HighArcons);
            return new VandralBattalion(Muggles, Healer, LowArchons, HighArcons);
        }

    }

}
