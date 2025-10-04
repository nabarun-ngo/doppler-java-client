package ngo.nabarun.doppler.model;

import lombok.Data;

@Data
public class Secret {
    private String key;
    private String value;
    private boolean sensitive;
}


