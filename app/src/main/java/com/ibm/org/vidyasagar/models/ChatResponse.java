package com.ibm.org.vidyasagar.models;

/**
 * Created by Vidyasagar MSC on 27/12/16.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChatResponse
{

        @SerializedName("entities")
        @Expose
        private List<Entity> entities = null;
        @SerializedName("intents")
        @Expose
        private List<Intent> intents = null;
        @SerializedName("input")
        @Expose
        private Input input;
        @SerializedName("output")
        @Expose
        private Output output;
        @SerializedName("context")
        @Expose
        private Context context;

        public List<Entity> getEntities() {
            return entities;
        }

        public void setEntities(List<Entity> entities) {
            this.entities = entities;
        }

        public List<Intent> getIntents() {
            return intents;
        }

        public void setIntents(List<Intent> intents) {
            this.intents = intents;
        }

        public Input getInput() {
            return input;
        }

        public void setInput(Input input) {
            this.input = input;
        }

        public Output getOutput() {
            return output;
        }

        public void setOutput(Output output) {
            this.output = output;
        }

        public Context getContext() {
            return context;
        }

        public void setContext(Context context) {
            this.context = context;
        }

    }