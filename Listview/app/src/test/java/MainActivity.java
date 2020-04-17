import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private WorkViewModel workViewModel;

    private FloatingActionButton floatingActionButton;
    public static final int add_note_request = 1;
    public static final int edit_note_request = 2;
    private int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WorkRepository repository = new WorkRepository((Application) getApplicationContext());




        floatingActionButton = findViewById(R.id.add_work_floating_button);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Addwork.class);
                startActivityForResult(intent, add_note_request);
            }
        });






        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final WorkAdapter workAdapter = new WorkAdapter();
        recyclerView.setAdapter(workAdapter);

        workViewModel = ViewModelProviders.of(this).get(WorkViewModel.class);
        workViewModel.getAllWorks().observe(this, new Observer<List<Work>>() {
            @Override
            public void onChanged(List<Work> works) {
                workAdapter.setNotes(works);
            }
        });


        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                workViewModel.delete(workAdapter.getWorkAt(viewHolder.getAdapterPosition()));
                Toast.makeText(MainActivity.this, "Work Completed", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

        workAdapter.setOnItemClickListener(new WorkAdapter.OnitemclickListener() {
            @Override
            public void onitemclick(Work work) {
//                editText.setText(work.getEvent_name());
//                textView1.setText(work.getDate());
//                textView2.setText(work.getDue_time());
//                ratingBar.setRating(work.getRating());
//                Toast.makeText(Addwork.this, "Update processing", Toast.LENGTH_SHORT).show();
//                id = work.getId();
//                editRequest = 1;
//                savebutton.setText("Update");
                Toast.makeText(MainActivity.this, "item clickeed" + work.getEvent_name(), Toast.LENGTH_SHORT).show();
                Intent data = new Intent(MainActivity.this, Addwork.class);
                data.putExtra(Addwork.eid, work.getId());
                data.putExtra(Addwork.ed1, work.getEvent_name());
                data.putExtra(Addwork.ed2, work.getDate());
                data.putExtra(Addwork.ed3, work.getDue_time());
                data.putExtra(Addwork.e_pri, work.getRating());
                startActivityForResult(data, edit_note_request);

            }

            @Override
            public void oncheckitemclick(Work work) {
                Toast.makeText(MainActivity.this, "work complete", Toast.LENGTH_SHORT).show();
                Intent data = new Intent();
//                data.putExtra(h_ed1, work.getEvent_name());

//                data.putExtra(h_ed2, work.getDate());
//                data.putExtra(h_ed3, work.getDue_time());
//                data.putExtra(h_e_pri, work.getRating());
                //setResult(RESULT_OK,data);
                // workViewModel.delete(work);
            }



        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == add_note_request && resultCode == RESULT_OK) {
            String title = data.getStringExtra(Addwork.ed1);
            String date = data.getStringExtra(Addwork.ed2);
            String due_date = data.getStringExtra(Addwork.ed3);
            float pir = data.getFloatExtra(Addwork.e_pri, 1);
            Work work = new Work(title, date, due_date, pir);
            workViewModel.insert(work);
            Toast.makeText(this, "work saved", Toast.LENGTH_SHORT).show();
        } else if (requestCode == edit_note_request && resultCode == RESULT_OK) {

            int id = data.getIntExtra(Addwork.eid, -1);

            if (id == -1) {
                Toast.makeText(this, "Work can't updated", Toast.LENGTH_SHORT).show();
                return;
            }

            String title = data.getStringExtra(Addwork.ed1);
            String date = data.getStringExtra(Addwork.ed2);
            String due_date = data.getStringExtra(Addwork.ed3);
            float pir = data.getFloatExtra(Addwork.e_pri, 1);
            Work work = new Work(title, date, due_date, pir);
            work.setId(id);
            workViewModel.update(work);
            Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "work not saved", Toast.LENGTH_SHORT).show();
        }


    }


}
