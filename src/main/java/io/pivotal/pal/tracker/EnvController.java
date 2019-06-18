package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {
    String P,ML,INSTANT,ADDR;
    public EnvController(@Value("${PORT:NOT SET}") String PORT, @Value("${MEMORY_LIMIT:NOT SET}") String MEMORY_LIMIT, @Value("${CF_INSTANCE_INDEX:NOT SET}") String CF_INSTANCE_INDEX, @Value("${CF_INSTANCE_ADDR:NOT SET}") String CF_INSTANCE_ADDR){
        this.P=PORT;
        this.ML=MEMORY_LIMIT;
        this.INSTANT=CF_INSTANCE_INDEX;
        this.ADDR=CF_INSTANCE_ADDR;
    }



    @GetMapping("/env")
    public  Map<String, String> getEnv() throws Exception {
        Map<String, String> env = new HashMap<>();

        env.put("PORT", P);
        env.put("MEMORY_LIMIT", ML);
        env.put("CF_INSTANCE_INDEX", INSTANT);
        env.put("CF_INSTANCE_ADDR", ADDR);

        return env;

    }
}
