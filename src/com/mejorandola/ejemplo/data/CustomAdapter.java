package com.mejorandola.ejemplo.data;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mejorandola.ejemplo.R;
import com.mejorandola.ejemplo.models.Room;

public class  CustomAdapter extends ArrayAdapter<Room> {
	
	ArrayList<Room> data;
	LayoutInflater inflater; // para inflar la vista

	public CustomAdapter(Context context, ArrayList<Room> objects) {
		super(context, -1, objects);
		// TODO Auto-generated constructor stub
		//inicializamos dentro del adapter
		this.data = objects;
		this.inflater = LayoutInflater.from(context);		
	}
	
	
	
	
	//se llama para visualizar cada uno de los elementos
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
//		return super.getView(position, convertView, parent);
		
		ViewHolder holder;
		Room current_room = data.get(position);
		String room_type = current_room.getRoomType();
		
		int img_resource = 0 ;
		if(room_type.equals(Room.STANDARD_ROOM)){
			img_resource = R.drawable.hotel1;
		}else{
			img_resource = R.drawable.hotel2;
		}
		
		//si la vista nunca ha sido visualizada 
		//converview es como si fuera la plantilla por cada item del listado
		if(convertView == null){
			convertView = inflater.inflate(R.layout.list_row, null);
			holder = new ViewHolder();
			holder.img = (ImageView) convertView.findViewById(R.id.img_row);
			holder.title = (TextView) convertView.findViewById(R.id.txt_row_title);
			holder.subtitle = (TextView) convertView.findViewById(R.id.txt_row_subtitle);
			
		convertView.setTag(holder);
		
		}else{
			holder = (ViewHolder)convertView.getTag();
		}
		
		//ahora trabajo solo donde el holder
		holder.title.setText(current_room.getRoomNumber());
		holder.subtitle.setText(room_type);
		holder.img.setImageResource(img_resource);
		
		
		return convertView;
	}





	//nos permitira sostener una vista
	private static class ViewHolder{
		public ImageView img;
		public TextView title;
		public TextView subtitle;
		
	}
	
}
