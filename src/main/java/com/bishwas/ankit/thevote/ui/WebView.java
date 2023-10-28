package com.bishwas.ankit.thevote.ui;

import com.bishwas.ankit.thevote.repository.VoteRepo;
import com.bishwas.ankit.thevote.service.VoteService;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route("/compare")
public class WebView extends Div {

    private boolean two_clicked;
    private boolean one_clicked;

    @Autowired
    private VoteService vote;

    @Autowired
    private VoteRepo voteRepo;
    public WebView(@Autowired VoteService vote,@Autowired VoteRepo voteRepo) {
        this.voteRepo=voteRepo;
        this.vote=vote;
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        textField1.setReadOnly(true);
        textField2.setReadOnly(true);
        SplitLayout splitLayout = new SplitLayout();
        VerticalLayout verticalLayout = new VerticalLayout();
        Span first = new Span("Pixel 8 Pro");
        Span second = new Span("Iphone 15 pro Max");
        verticalLayout.add(first);
        VerticalLayout verticalLayout1 = new VerticalLayout();
        verticalLayout1.add(second);
        splitLayout.addToPrimary(verticalLayout);
        splitLayout.addToSecondary(verticalLayout1);


        Icon up_o = VaadinIcon.THUMBS_UP_O.create();
        Icon up1_o = VaadinIcon.THUMBS_UP_O.create();
        Icon up = VaadinIcon.THUMBS_UP.create();
        up.setVisible(false);
        Icon up1 = VaadinIcon.THUMBS_UP.create();
        up1.setVisible(false);
        verticalLayout.add(up);
        verticalLayout.add(up_o);
        verticalLayout1.add(up1_o);
        verticalLayout1.add(up1);
        long [] votes = vote.displayVote();
        textField1.setValue(votes[0]+"");
        textField2.setValue(votes[1]+"");


        Image image = new Image();
        image.setSrc("images/iphone.jpg");


        if(!two_clicked)
            up_o.addClickListener(e-> {
                if(two_clicked) return;
                Notification.show("Vote added...");
                up_o.setVisible(false);
                up.setVisible(true);
                one_clicked=true;
                vote.addVote(1,true,false);

            });
        if(!one_clicked)
            up1_o.addClickListener(e-> {
                if(one_clicked) return;
                Notification.show("Vote added...");
                up1_o.setVisible(false);
                up1.setVisible(true);
                two_clicked=true;
                vote.addVote(1,false,true);
            });


        Span first_result = new Span("Total no. of Votes for Pixel: ");

        textField1.setValueChangeMode(ValueChangeMode.EAGER);
        textField2.setValueChangeMode(ValueChangeMode.EAGER);
        Span second_result = new Span("Total no. of Votes for Iphone: ");
        verticalLayout.add(first_result,image,textField1);
        verticalLayout.setHeight("80%");
        verticalLayout1.add(second_result,textField2);





        first_result.getStyle().set("margin-top","55%");
        textField1.getStyle().set("margin-top","2px");
        textField2.getStyle().set("margin-top","2px");
        second_result.getStyle().set("margin-top","55%");


        add(splitLayout);
        splitLayout.setHeight("100%");
//        splitLayout.getStyle().set("background","blue");
        setHeight("100%");

    }
}
