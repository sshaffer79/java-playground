package com.shaffer.treehierarchy.model;

import java.util.List;

public class Event {
    private int id;
     private int pid;
     private int targetPid;
     private Action action;
     private List<String> files;
     private Network network;
}
