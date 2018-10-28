/*
 * Author: Leonardo Ribeiro Guimaraes
 * RA: 816119319
 */

package br.com.leoribeiorweb.pipocaccp3anbua;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.leoribeiorweb.pipocaccp3anbua.model.Film;

public class FilmAdapter extends ArrayAdapter<Film> {
    public FilmAdapter(Context context, List<Film> filmList) {
        super(context, -1, filmList);
    }

    private static class ViewHolder {
        // ImageView imageView;
        TextView name;
        RatingBar voteAvarenge;
        ImageView imageView;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Film film = getItem(position);
        View root = null;
        ViewHolder viewHolder = null;
        Context context = getContext();
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            root = inflater.inflate(R.layout.list_film_adapter, parent, false);
            viewHolder = new ViewHolder();
            root.setTag(viewHolder);
            viewHolder.name = root.findViewById(R.id.name);
            viewHolder.voteAvarenge = root.findViewById(R.id.voteAvarenge);
            viewHolder.imageView = root.findViewById(R.id.imagem);
        } else {
            root = convertView;
            viewHolder = (ViewHolder) root.getTag();
        }

        viewHolder.name.setText(film.getTitle());
        viewHolder.voteAvarenge.setRating(Float.parseFloat(film.getVoteAverage()) / 2);
        Picasso.get().load("https://image.tmdb.org/t/p/w200" + film.getPosterPath()).into(viewHolder.imageView);

        return root;
    }
}
