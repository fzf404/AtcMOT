package moe.dazecake.atc.service;

import moe.dazecake.atc.pojo.CrimeUper;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface CrimeUpService {
    void addCrime(CrimeUper crimeUper) throws IOException;
}
