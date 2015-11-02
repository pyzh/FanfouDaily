package io.github.anthonyeef.fanfoudaily.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import io.github.anthonyeef.fanfoudaily.R;
import io.github.anthonyeef.fanfoudaily.model.Fanfou;

/**
 * Created by anthonyeef on 10/31/15.
 */
public class UIStatus extends AppCompatActivity{

    @Bind(R.id.avatar1) CircleImageView avatar1;
    @Bind(R.id.name1) TextView name1;
    @Bind(R.id.timestamp1) TextView timestamp1;
    @Bind(R.id.status1) TextView status1;
    @Bind(R.id.image1) ImageView image1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();


        setContentView(R.layout.activity_status);
        ButterKnife.bind(this);

        Fanfou feed = (Fanfou) intent.getParcelableExtra("feed");

        name1.setText(feed.getScreenName());
        timestamp1.setText(feed.getTimeStamp());
        status1.setText(feed.getStatus());

        Picasso.with(this).load(feed.getAvatarUrl()).into(avatar1);
        if (!feed.getImageUrl().equals("")) {
            Picasso.with(this).load(feed.getImageUrl()).into(image1);
        }
    }

}