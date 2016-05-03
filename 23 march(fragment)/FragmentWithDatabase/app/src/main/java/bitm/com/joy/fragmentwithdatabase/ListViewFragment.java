package bitm.com.joy.fragmentwithdatabase;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListViewFragment extends Fragment {
    ListView listView;
    ArrayList<StudentList> list;
    DataBaseManager manager;

    public ListViewFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_view, container, false);
        listView=(ListView)view.findViewById(R.id.listView);

        manager=new DataBaseManager(view.getContext());

        list=new ArrayList<>();
        list=manager.getAllStudent();

        StudentListAdapter adapter=new StudentListAdapter(view.getContext(),list);

        listView.setAdapter(adapter);
        return view;
    }


}
