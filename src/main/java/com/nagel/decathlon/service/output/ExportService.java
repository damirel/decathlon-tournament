package com.nagel.decathlon.service.output;

import com.nagel.decathlon.domain.Tournament;

/**
 * ExportService.
 * <p>
 * Date: 29/08/2020
 *
 * @author dfatkulin
 */
public interface ExportService {

    void export(Tournament tournament, String fileName);

}
