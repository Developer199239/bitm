package bitm.com.joy.fragmentwithdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Mobile App Develop on 16-3-16.
 */
public class StudentListAdapter extends ArrayAdapter<StudentList> {

    private ArrayList<StudentList> studentLists;
    private Context context;

    public StudentListAdapter(Context context, ArrayList<StudentList> studentLists) {
        super(context, R.layout.custom_row_student, studentLists);
        this.context = context;
        this.studentLists = studentLists;
    }

    static class ViewHolder {
        TextView nameTv;
        TextView emailTv;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_row_student, null);

            viewHolder = new ViewHolder();
            viewHolder.nameTv = (TextView) convertView.findViewById(R.id.nameTv);
            viewHolder.emailTv = (TextView) convertView.findViewById(R.id.emailTv);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.nameTv.setText(studentLists.get(position).getUserName());
        viewHolder.emailTv.setText(studentLists.get(position).getUserEmail());

        return convertView;
    }
}
