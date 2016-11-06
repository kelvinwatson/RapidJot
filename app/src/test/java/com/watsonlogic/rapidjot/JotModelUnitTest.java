package com.watsonlogic.rapidjot;

import com.watsonlogic.rapidjot.model.Jot;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author: Kelvin Watson
 */

public class JotModelUnitTest {

    @Test
    public void getId(){
        Date jotId = new Date();
        Jot currentJot = new Jot(jotId);
        assertThat(currentJot.getId(), is(jotId.getTime()));
    }

    @Test
    public void getTitle(){
        Date jotId = new Date();
        Jot currentJot = new Jot(jotId);
        assertThat(currentJot.getId(), is(jotId.getTime()));
        currentJot.setTitle("some title");
        assertThat(currentJot.getTitle(), is("some title"));
    }

    @Test
    public void getPlainText(){
        Date jotId = new Date();
        Jot currentJot = new Jot(jotId);
        assertThat(currentJot.getId(), is(jotId.getTime()));
        currentJot.setPlainTextContent("some plain text content");
        assertThat(currentJot.getPlainTextContent(), is("some plain text content"));
    }
}
