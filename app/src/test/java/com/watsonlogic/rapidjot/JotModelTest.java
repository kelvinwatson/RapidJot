package com.watsonlogic.rapidjot;

import com.watsonlogic.rapidjot.model.Jot;
import com.watsonlogic.rapidjot.presenter.JotPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * @author: Kelvin Watson
 */

public class JotModelTest {

    @Test
    public void getId(){
        Date jotId = new Date();
        Jot currentJot = new Jot(jotId);
        assertThat(currentJot.getId(), is(jotId));
    }

    @Test
    public void getTitle(){
        Date jotId = new Date();
        Jot currentJot = new Jot(jotId);
        assertThat(currentJot.getId(), is(jotId));
        currentJot.setTitle("some title");
        assertThat(currentJot.getTitle(), is("some title"));
    }

    @Test
    public void getPlainText(){
        Date jotId = new Date();
        Jot currentJot = new Jot(jotId);
        assertThat(currentJot.getId(), is(jotId));
        currentJot.setPlainTextContent("some plain text content");
        assertThat(currentJot.getPlainTextContent(), is("some plain text content"));
    }
}
