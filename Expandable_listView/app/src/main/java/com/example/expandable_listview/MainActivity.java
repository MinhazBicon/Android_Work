package com.example.expandable_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SimpleTimeZone;

public class MainActivity extends AppCompatActivity {
      private ExpandableListView expandableListView;
      List<String> list_data_header;
      HashMap<String,List<String>> list_data_child;
      private int last_collapse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView = findViewById(R.id.expandble_listView);

        expandable_list_data();

        CustomAdapter customadapter = new CustomAdapter(this,list_data_header,list_data_child);
        expandableListView.setAdapter(customadapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                String group_head  = list_data_header.get(groupPosition);
                Toast.makeText(getApplicationContext(),group_head,Toast.LENGTH_LONG).show();
                return false;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String child_value = list_data_child.get(list_data_header.get(groupPosition)).get(childPosition);
                Toast.makeText(getApplicationContext(),child_value,Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if (last_collapse != -1 && groupPosition != last_collapse){
                    expandableListView.collapseGroup(last_collapse);
                    last_collapse = groupPosition;
                }
            }
        });


    }

    public void expandable_list_data(){
        //String[] header_name = getResources().getStringArray(R.array.header_Array_name);
        //String[] child_name = getResources().getStringArray(R.array.child_Array_name);

        //  Adding data directly here.....
        list_data_header = new ArrayList<String>();
        list_data_child = new HashMap<>();

        list_data_header.add("1. DNA");
        List<String> DNA = new ArrayList<String>();
        DNA.add("1.1 Deoxy-Ribo-Nucleic Acid");
        DNA.add("1.2 a self-replicating material which is present in nearly all living organisms as the main constituent of chromosomes.");
        DNA.add("1.3  It is the carrier of genetic information.");
        list_data_child.put(list_data_header.get(0),DNA);

        list_data_header.add("2. RNA");
        List<String> RNA = new ArrayList<String>();
        RNA.add("2.1. Ribo-Nucleic acid");
        RNA.add("2.2. A nucleic acid present in all living cells.");
        RNA.add("2.3. Its principal role is to act as a messenger carrying instructions from DNA");
        list_data_child.put(list_data_header.get(1),RNA);

        list_data_header.add("3. Virus");
        List<String> virus = new ArrayList<String>();
        virus.add("3.1. A virus is a small infectious agent");
        virus.add("3.2. Viruses can infect all types of life forms, from animals and plants");
        list_data_child.put(list_data_header.get(2),virus);

        list_data_header.add("4. Bacteria");
        List<String> bacteria = new ArrayList<String>();
        bacteria.add("4.1. Bacteria are microscopic, single-celled organisms");
        bacteria.add("4.2. Humans' relationship with bacteria is complex.");
        bacteria.add("4.3. Sometimes bacteria lend us a helping hand, such as by curdling milk into yogurt or helping with our digestion.");
        bacteria.add("4.4. Thrive in diverse environments. These organisms can live in soil, the ocean and inside the human gut.");
        list_data_child.put(list_data_header.get(3),bacteria);

        list_data_header.add("5. Mosses");
        List<String> mosses = new ArrayList<String>();
        mosses.add("5.1. Mosses are non-vascular plants in the land plant division Bryophyta.");
        mosses.add("5.2. They produce spores for reproduction instead of seeds and don't grow flowers, wood or true roots.");
        mosses.add("5.3. Instead of roots, all species of moss have rhizoids.");
        mosses.add("5.4. Mosses are a phylum of non-vascular plants.");
        list_data_child.put(list_data_header.get(4),mosses);

        list_data_header.add("6. Biotin");
        List<String> biotin = new ArrayList<String>();
        biotin.add("6.1. Biotin is a water-soluble vitamin that's a part of the vitamin B family.");
        biotin.add("6.2. It's also known as vitamin H. Your body needs biotin to help convert certain nutrients into energy.");
        biotin.add("6.3. It also plays an important role in the health of your hair, skin, and nails.");
        biotin.add("6.4. Also known as vitamin H, biotin is one of the B complex vitamins.");
        list_data_child.put(list_data_header.get(5),biotin);

        list_data_header.add("7. Protein");
        List<String> protein = new ArrayList<String>();
        protein.add("7.1. Also known as vitamin H, biotin is one of the B complex vitamins ");
        protein.add("7.2. It is commonly found in animal products, though is also present in other sources, such as nuts and legumes.");
        protein.add("7.3. Proteins are large biomolecules, or macromolecules.");
        list_data_child.put(list_data_header.get(6),protein);

        list_data_header.add("8. Fat");
        List<String> fat = new ArrayList<String>();
        fat.add("8.1. Fats or fatty acids: These terms can refer to any type of fat.");
        fat.add("8.2. Fats usually describes those that are solid at room temperature.");
        list_data_child.put(list_data_header.get(7),fat);

        list_data_header.add("9. Influenaza");
        List<String> influenza = new ArrayList<String>();
        influenza.add("9.1. Influenza is a viral infection that attacks your respiratory system.");
        influenza.add("9.2. Influenza is commonly called the flu, but it's not the same as stomach \"flu\" viruses that cause diarrhea and vomiting. " +
                "For most people, influenza resolves on its own.");
        list_data_child.put(list_data_header.get(8),influenza);

        list_data_header.add("10. Alcohol");
        List<String> alcohol = new ArrayList<String>();
        alcohol.add("10.1. In chemistry, alcohol is an organic compound that carries at least one " +
                "hydroxyl functional group (−OH) bound to a saturated carbon atom.");
        alcohol.add("10.2.  The term alcohol originally referred to the primary alcohol ethanol (ethyl alcohol), which is used as a drug");
        list_data_child.put(list_data_header.get(9),alcohol);

        list_data_header.add("11. Sodium");
        List<String> sodium = new ArrayList<String>();
        sodium.add("11.1. Fats or fatty acids: These terms can refer to any type of fat.");
        sodium.add("11.2. Fats usually describes those that are solid at room temperature.");
        list_data_child.put(list_data_header.get(10),sodium);

        list_data_header.add("12. Iron");
        List<String> iron= new ArrayList<String>();
        iron.add("12.1. Iron is a mineral that our bodies need for many functions.");
        iron.add("12.2. Iron is part of hemoglobin, a protein which carries oxygen from our lungs throughout our bodies.");
        list_data_child.put(list_data_header.get(11),iron);

        list_data_header.add("13. Synapse");
        List<String> synapse = new ArrayList<String>();
        synapse.add("13.1.  A synapse is a structure that permits a neuron to pass an electrical or chemical signal to " +
                "another neuron or to the target effector cell..");
        synapse.add("13.2. Neurons communicate with one another at junctions called synapses.");
        synapse.add("13.3. Synapse, also called neuronal junction, the site of transmission of electric nerve impulses.");
        list_data_child.put(list_data_header.get(12),synapse);

        list_data_header.add("14. Plant");
        List<String> plant = new ArrayList<String>();
        plant.add("14.1. Plant noun (LIVING THING) A1 [ C ] a living thing that grows in earth.");
        plant.add("14.2. Plants, usually has a stem, leaves, roots, and flowers, and produces seeds: native plants and animals.");
        list_data_child.put(list_data_header.get(13),plant);

        list_data_header.add("8. Corona");
        List<String> corona = new ArrayList<String>();
        corona.add("8.1. Coronavirus disease (COVID-19) is an infectious disease.");
        corona.add("8.2. Caused by a newly discovered coronavirus. Most people infected with the COVID-19 virus.");
        list_data_child.put(list_data_header.get(14),corona);

        list_data_header.add("16. Spanish Flue");
        List<String> spanishFlue = new ArrayList<String>();
        spanishFlue.add("16.1. The Spanish flu, also known as the 1918 flu pandemic, was an unusually deadly influenza pandemic.");
        spanishFlue.add("16.2. The 1918 influenza pandemic was the most severe pandemic in recent history. ..." +
                "Influenza of 1918 (Spanish Flu) and the U.S. Navyexternal icon · Glezen WP.");
        list_data_child.put(list_data_header.get(15),spanishFlue);

        }
    }





