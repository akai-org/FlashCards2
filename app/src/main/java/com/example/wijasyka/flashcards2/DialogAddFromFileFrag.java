package com.example.wijasyka.flashcards2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by hp on 2018-04-21.
 */

public class DialogAddFromFileFrag extends DialogFragment implements View.OnClickListener {
    ComunicatorAddFromFile comunicator;
    Button addButton;
    EditText tableName;
    EditText path;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_dialog_add_from_file, container, false);
        Button addButton=(Button) view.findViewById(R.id.addButton);
        EditText tableName=(EditText) view.findViewById(R.id.tablename);
        EditText path=(EditText) view.findViewById(R.id.path);
        this.path=path;
        this.addButton=addButton;
        this.tableName=tableName;
        addButton.setOnClickListener(this);
        return view;

    }
    @Override
    public void onAttach(Context context){
        Activity a;
        a=(Activity)context;
        super.onAttach((context));
        comunicator= (DialogAddFromFileFrag.ComunicatorAddFromFile) a;
    }
    public  void onClick(View view){
        String tableNameFromEditText=new String(tableName.getText().toString());
        String pathFromEditText=new String(path.getText().toString());
        comunicator.messageFromAddFromFileFragment(pathFromEditText,tableNameFromEditText);
        getDialog().dismiss();
    }
    interface ComunicatorAddFromFile{
        public void messageFromAddFromFileFragment(String path,String tableName);
    }

}

