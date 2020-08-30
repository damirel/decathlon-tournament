package com.nagel.decathlon.service.tournament;

import com.nagel.decathlon.domain.Athlete;
import com.nagel.decathlon.domain.Tournament;

import java.util.List;

/**
 * TournamentService.
 * <p>
 * Date: 29/08/2020
 *
 * @author dfatkulin
 */
public interface TournamentService {

    Tournament calculateResult(List<Athlete> athletes);

}
