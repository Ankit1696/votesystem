package com.bishwas.ankit.thevote.ui;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/img")
public class ImageView extends VerticalLayout {
    public ImageView(){
        Image image = new Image();
        image.setSrc("../../../frontend/images/thai-nguyen-AtYWWis5ZDM-unsplash.jpg");
        add(image);
    }
}
