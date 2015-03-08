package io.alextu.demoquerydsl.blog

import groovy.transform.Canonical

/**
 * Created by alexis on 06/03/15.
 */
@Canonical
class Blog {

    int id
    String title
    List<Tag> tags

}
