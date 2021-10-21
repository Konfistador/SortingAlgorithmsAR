package algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class BogoSortTest {

    @Test
    public void dataCanBeFedAndRetrieved(){
        var sut = new BogoSort();
        var inputArg =  new int[]{5,6,7,3,2,1,3,4,5,1,233,4112,3};
        sut.feedData(inputArg);

        assertThat(sut.getOutputCollection())
                .as("Expecting an Algorithm to be fed with a collection, that can be later retrieved")
                .isEqualTo(inputArg);

        fail("dataCanBeFedAndRetrieved test method completed. You know what to do");
    }

}