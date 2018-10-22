package br.com.leoribeiorweb.pipocaccp3anbua;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/*
* Author: Leonardo Ribeiro
* RA: 816119319
* */
public class FilmAdapter extends ArrayAdapter<Film> {
    public FilmAdapter(Context context, List<Film> filmList) {
        super(context, -1, filmList);
    }

    private static class ViewHolder {
        // ImageView imageView;
        TextView name;
        TextView genre;
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
            viewHolder.genre = root.findViewById(R.id.genre);
        } else {
            root = convertView;
            viewHolder = (ViewHolder) root.getTag();
        }

        viewHolder.name.setText(film.getName());
        viewHolder.genre.setText(film.getGenre());

        return root;
    }
}
