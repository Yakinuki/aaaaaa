import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicTest {

    @Test
    void test() {
        //----------------------------
        // Arrange

        System.out.println("----- Am Anfang -----");
        System.out.println();
        dasSpiel.visualisieren();
        System.out.println();

        //----------------------------
        // Act
        dasSpiel.drankommen(1);
        dasSpiel.drankommen(3);

        System.out.println("----- Noch nicht beendet -----");
        System.out.println();
        dasSpiel.visualisieren();
        System.out.println();

        //----------------------------
        // Assert
        assertFalse(dasSpiel.gewinnErmitteln());

        //----------------------------
        // Act
        dasSpiel.drankommen(0);
        dasSpiel.drankommen(2);
        dasSpiel.drankommen(4);

        System.out.println("----- Am Ende -----");
        System.out.println();
        dasSpiel.visualisieren();
        System.out.println();

        //----------------------------
        // Assert
        assertTrue(dasSpiel.gewinnErmitteln());
    }
}