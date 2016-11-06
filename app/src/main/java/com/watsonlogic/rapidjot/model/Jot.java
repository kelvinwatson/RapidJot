package com.watsonlogic.rapidjot.model;

import java.util.Date;

/**
 * A jot is a note created by the user, and can serve as a pre-cursor to a formal {@link Post}
 *
 * @author: Kelvin Watson
 */
public class Jot {

    private Long id; //each jot is uniquely identified by the date & time of creation (Date to Long)
    private String title;
    private String plainTextContent;

    public Jot()
    {

    }

    public Jot(Date id) {
        this.id = id.getTime();
    }

    public Jot(Date inception, String title, String plainTextContent) {
        this.id = inception.getTime();
        this.title = title;
        this.plainTextContent = plainTextContent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Date id) {
        this.id = id.getTime();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlainTextContent() {
        return plainTextContent;
    }

    public void setPlainTextContent(String plainTextContent) {
        this.plainTextContent = plainTextContent;
    }
}
