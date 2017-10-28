package br.com.seniors.service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dell
 */
@Service
public class CodeGeneratorService {

    private static final Set<Integer> CODES = new HashSet<>();
    private static final Random RAND = new Random();

    static int maximum = 9999, minimum = 1000, randomNum;

    public String getCode() {
        int code = RAND.nextInt((maximum - minimum) + 1) + minimum;

        CODES.add(code);

        return "" + code;
    }
}
