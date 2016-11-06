package com.watsonlogic.rapidjot;

import com.watsonlogic.rapidjot.model.Jot;
import com.watsonlogic.rapidjot.model.JotModel;
import com.watsonlogic.rapidjot.presenter.AllJotsPresenter;
import com.watsonlogic.rapidjot.presenter.JotEditorPresenter;
import com.watsonlogic.rapidjot.view.AllJotsViewOpsExposedToPresenter;
import com.watsonlogic.rapidjot.view.JotEditorViewOpsExposedToPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author: Kelvin Watson
 */
public class AllJotsPresenterJUnitTest {

    private AllJotsPresenter allJotsPresenter;
    private JotEditorPresenter jotEditorPresenter;
    private JotModel model;

    @Mock
    private AllJotsViewOpsExposedToPresenter mockAllJotsView;
    @Mock
    private JotEditorViewOpsExposedToPresenter mockEditorView;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        allJotsPresenter = new AllJotsPresenter(mockAllJotsView);
        jotEditorPresenter = new JotEditorPresenter(mockEditorView);
        model = new JotModel(jotEditorPresenter);
        allJotsPresenter.setModel(model);
        jotEditorPresenter.setModel(model);
    }

    @Test
    public void createJot() throws InterruptedException {
        allJotsPresenter.getJots();
        assertThat(model.getJots(), notNullValue());
        assertThat(model.getJots().isEmpty(), is(true));

        Date now = new Date();
        jotEditorPresenter.createJot(now);
        assertThat(model.getJotCount(), is(1));
        assertThat(model.getJot(0).getId(), is(now.getTime())); //assert local copy added
        assertThat(model.fetchJots().get(0).getId(), is(now.getTime()));

        Thread.sleep(1);

        now = new Date();
        jotEditorPresenter.createJot(now);
        assertThat(model.getJotCount(), is(2));
        assertThat(model.getJot(1).getId(), is(now.getTime())); //assert local copy added
        assertThat(model.fetchJots().get(1).getId(), is(now.getTime())); //assert database contains jot
    }

    @Test
    public void setCurrentJot() throws InterruptedException {
        //Create three jots
        Date one = new Date();
        jotEditorPresenter.createJot(one);
        Thread.sleep(1);

        Date two = new Date();
        jotEditorPresenter.createJot(two);
        Thread.sleep(1);

        Date three = new Date();
        jotEditorPresenter.createJot(three);

        allJotsPresenter.getJots();
        assertThat(model.getJots(), notNullValue());
        assertThat(model.getJots().size(), is(3));

        assertThat(model.getJots().get(0).getId(), is(one.getTime()));
        assertThat(model.getJots().get(1).getId(), is(two.getTime()));
        assertThat(model.getJots().get(2).getId(), is(three.getTime()));

        Jot jot = new Jot(two);
        jotEditorPresenter.setJotUnderEdit(jot);
        assertThat(jotEditorPresenter.getJotUnderEdit().getId(), is(two.getTime()));
    }
//
//    @Test
//    public void updateCurrentJot(){
//        AllJotsFragment view = Mockito.mock(AllJotsFragment.class);
//        AllJotsAllJotsPresenter presenter = new AllJotsAllJotsPresenter(view);
//        Date id = new Date();
//        presenter.createJot(id);
//        presenter.updateCurrentJot("someTitle", "some plain text");
//        assertThat(presenter.getCurrentJot().getId(), is(id));
//        assertThat(presenter.getCurrentJot().getTitle(), is("someTitle"));
//        assertThat(presenter.getCurrentJot().getPlainTextContent(), is("some plain text"));
//    }
}
