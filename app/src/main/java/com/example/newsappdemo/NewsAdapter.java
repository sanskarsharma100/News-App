package com.example.newsappdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }
    //method for converting date in proper format
    private String formatDate(String dateObj) {
        String dateFormatted = "";
        SimpleDateFormat inputDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
        SimpleDateFormat outputDate = new SimpleDateFormat("EEEE, dd.MM.yyyy", Locale.getDefault());
        try {
            Date newDate = inputDate.parse(dateObj);
            return outputDate.format(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormatted;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        News currentNews = getItem(position);
        //Getting section name by calling proper method
        TextView sectionName = listItemView.findViewById(R.id.section_name);
        sectionName.setText(currentNews.getSection());
        //Getting Title name by calling proper method
        TextView titleName = listItemView.findViewById(R.id.title_name);
        titleName.setText(currentNews.getTitle());
        //Getting Author name by calling proper method
        TextView authorName = listItemView.findViewById(R.id.author);
        authorName.setText(currentNews.getAuthor());
        //Getting new thumbnail by extracting image from url using Glide
        ImageView thumbnail = listItemView.findViewById(R.id.thumbnail);
        final String imageUrl = currentNews.getThumbnail();
        if (imageUrl.equals("")) {
            thumbnail.setImageResource(R.drawable.default_image);
        } else {
            Glide.with(listItemView).load(imageUrl).override(400, 400).centerCrop().into(thumbnail);
        }
        //Getting date by calling proper method
        final String date = currentNews.getDate();
        //Converting date to proper format
        final String newsDate = formatDate(date);
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        dateView.setText(newsDate);
        return listItemView;
    }

}
