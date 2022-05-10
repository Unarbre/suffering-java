package grx.dod.demo.tp.contracts;

import java.util.List;

public interface FileParser<Parsed> {

    List<Parsed> parse(String filepath) throws Exception;
}
