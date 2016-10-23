package com.watsonlogic.rapidjot.model;

import android.text.Editable;

import java.util.Date;

/**
 * A post is a more-complete version of a {@link Jot} that serves as a blog post of sorts.
 *
 * @author: Kelvin Watson
 */
public class Post extends Jot {

    private String title;
    private Editable jotContentRich; //rich text to be displayed in an EditText
    private String jotContentHtml;

    public Post(Date id, String title, Editable jotContentRich, String jotContentHtml) {
        super(id);
        this.title = title;
        this.jotContentRich = jotContentRich;
        this.jotContentHtml = jotContentHtml;
    }

    public Post(Date inception, String title, String plainTextContent, String title1, Editable jotContentRich, String jotContentHtml) {
        super(inception, title, plainTextContent);
        this.title = title1;
        this.jotContentRich = jotContentRich;
        this.jotContentHtml = jotContentHtml;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Editable getJotContentRich() {
        return jotContentRich;
    }

    public void setJotContentRich(Editable jotContentRich) {
        this.jotContentRich = jotContentRich;
    }

    public String getJotContentHtml() {
        return jotContentHtml;
    }

    public void setJotContentHtml(String jotContentHtml) {
        this.jotContentHtml = jotContentHtml;
    }
}