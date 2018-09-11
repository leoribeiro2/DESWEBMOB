package br.com.leoribeiroweb.servicedeskccp3anbua.adpater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import br.com.leoribeiroweb.servicedeskccp3anbua.R;
import br.com.leoribeiroweb.servicedeskccp3anbua.model.Chamado;

public class ChamadosAdapter extends ArrayAdapter<Chamado> {

    private List<Chamado> chamados;
    private Context context;

    public ChamadosAdapter (List<Chamado> chamados, Context context) {
        super(context, -1, chamados);
        this.context = context;
        this.chamados = chamados;
    }

    @Override
    public int getCount() {
        return this.chamados.size();
    }

    @Override
    public Chamado getItem(int position) {
        return this.chamados.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        Chamado deInteresse = chamados.get(position);
        TextView filaDoItemTextView;
        TextView descricaoDoItemTextView;
        ViewHolder vh;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(this.context);
            convertView = inflater.inflate(R.layout.item_list, parent, false);
            filaDoItemTextView = convertView.findViewById(R.id.filaDoItemTextView);
            descricaoDoItemTextView = convertView.findViewById(R.id.descricaoDoItemTextView);
            vh = new ViewHolder();
            vh.descricaoDoItemTextView = descricaoDoItemTextView;
            vh.filaDoItemTextView = filaDoItemTextView;
            convertView.setTag(vh);
        }
        vh = (ViewHolder) convertView.getTag();
        vh.filaDoItemTextView.setText(deInteresse.getTipo());
        vh.descricaoDoItemTextView.setText(deInteresse.getNome());
        return convertView;
    }

    private class ViewHolder  {
        TextView filaDoItemTextView;
        TextView descricaoDoItemTextView;
    }
}
