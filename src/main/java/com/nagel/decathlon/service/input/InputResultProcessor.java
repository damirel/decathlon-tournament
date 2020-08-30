package com.nagel.decathlon.service.input;

import com.nagel.decathlon.domain.Athlete;

import java.util.List;

/**
 * InputResultProcessor.
 * <p>
 * Date: 29/08/2020
 *
 * @author dfatkulin
 */
public interface InputResultProcessor {

    List<Athlete> loadInputResult(String filePath);

}
