package com.watsonlogic.rapidjot;

import com.watsonlogic.rapidjot.presenter.JotPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

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
    ViewOpsExposedToPresenter mockPresenterInterface;

    @Before
    public void setup() {
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
}
