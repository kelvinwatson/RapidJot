package com.watsonlogic.rapidjot;

import android.app.Activity;
import android.view.View;

import com.watsonlogic.rapidjot.model.Jot;
import com.watsonlogic.rapidjot.model.JotModel;
import com.watsonlogic.rapidjot.presenter.JotPresenter;
import com.watsonlogic.rapidjot.view.AllJotsFragment;
import com.watsonlogic.rapidjot.view.MainActivity;
import com.watsonlogic.rapidjot.view.ViewOpsExposedToPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.Whitebox;

import java.util.Date;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author: Kelvin Watson
 */
public class JotPresenterJUnitTest {

    private JotPresenter presenter;

    @Mock
    private ViewOpsExposedToPresenter mockPresenterInterface;

    @Mock
    private JotModel jotModel;

    @InjectMocks
    private Jot currentJot;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new JotPresenter(mockPresenterInterface);
    }

    @Test
    public void createJot() throws InterruptedException {
        assertThat(presenter.getJots(), notNullValue());
        assertThat(presenter.getJots().isEmpty(), is(true));

        Date now = new Date();
        presenter.createJot(now);
        assertTrue(presenter.getJots().containsKey(now.getTime()));
        assertThat(presenter.getJots().size(), is(1));

        Thread.sleep(1);

        now = new Date();
        presenter.createJot(now);
        assertTrue(presenter.getJots().containsKey(now.getTime()));
        assertThat(presenter.getJots(), notNullValue());
        assertThat(presenter.getJots().size(), is(2));
    }

    @Test
    public void setCurrentJot() throws InterruptedException {
        //Create three jots
        Date one = new Date();
        presenter.createJot(one);
        Thread.sleep(1);

        Date two = new Date();
        presenter.createJot(two);
        Thread.sleep(1);

        Date three = new Date();
        presenter.createJot(three);

        assertThat(presenter.getJots(), notNullValue());
        assertThat(presenter.getJots().size(), is(3));

        assertThat(presenter.getJots().containsKey(one.getTime()), is(true));
        assertThat(presenter.getJots().containsKey(two.getTime()), is(true));
        assertThat(presenter.getJots().containsKey(three.getTime()), is(true));

        presenter.setCurrentJot(two);
        //check that the current jot that the user is working with is in the map of jots
        assertThat(presenter.getCurrentJot().getId().getTime(), is(two.getTime()));
    }

    @Test
    public void updateCurrentJot(){
        AllJotsFragment view = Mockito.mock(AllJotsFragment.class);
        JotPresenter presenter = new JotPresenter(view);
        Date id = new Date();
        presenter.createJot(id);
        presenter.updateCurrentJot("someTitle", "some plain text");
        assertThat(presenter.getCurrentJot().getId(), is(id));
        assertThat(presenter.getCurrentJot().getTitle(), is("someTitle"));
        assertThat(presenter.getCurrentJot().getPlainTextContent(), is("some plain text"));
    }
}
