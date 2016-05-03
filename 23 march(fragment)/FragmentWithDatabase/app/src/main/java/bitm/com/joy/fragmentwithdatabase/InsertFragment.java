package bitm.com.joy.fragmentwithdatabase;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class InsertFragment extends Fragment{
    EditText nameEt,emailEt;
    Button submitBt;
    DataBaseManager manager;

    public InsertFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_insertinformation, container, false);
        nameEt=(EditText)view.findViewById(R.id.nameEt);
        emailEt=(EditText)view.findViewById(R.id.emaiEt);
        submitBt=(Button)view.findViewById(R.id.submitBt);
        manager=new DataBaseManager(getActivity());
        submitBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentList studentList=new StudentList(nameEt.getText().toString(),emailEt.getText().toString());
                boolean isinsert=manager.addStudent(studentList);
                if (isinsert){

                    Toast.makeText(v.getContext(),"insert",Toast.LENGTH_SHORT).show();
                    ListViewFragment fragment=new ListViewFragment();
                    FragmentManager manager=getFragmentManager();
                    FragmentTransaction transaction=manager.beginTransaction();
                    transaction.replace(R.id.myFragment,fragment);
                    transaction.commit();
                }
                else{
                    Toast.makeText(v.getContext(),"Error",Toast.LENGTH_SHORT).show();
                }


            }
        });




        return view;
    }


}
