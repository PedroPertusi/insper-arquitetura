package com.insper.partida.aposta;

import com.insper.partida.game.Game;
import com.insper.partida.game.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BetService {

    @Autowired
    private BetRespository betRespository;

    @Autowired
    private GameService gameService;


    public Bet saveBet(Bet bet) {
        Game game = gameService.getGame(bet.getGame().getIdentifier());
        if (game == null) {
            throw new RuntimeException("Game not found");
        }

        bet.setGame(game);
        return betRespository.save(bet);

    }

    public List<Bet> listBets() {
        return betRespository.findAll();
    }

    public Bet verifyBet(Integer betId) {
        Bet bet = betRespository.findById(betId).get();
        Game game = bet.getGame();
        if (bet.getResult().equals(BetResult.AWAY)) {
            if (game.getScoreAway() > game.getScoreHome()) {
                bet.setStatus(BetStatus.WON);
            }
            else {
                bet.setStatus(BetStatus.LOST);
            }
        }
        else if (bet.getResult().equals(BetResult.HOME)) {
            if (game.getScoreAway() < game.getScoreHome()) {
                bet.setStatus(BetStatus.WON);
            }
            else {
                bet.setStatus(BetStatus.LOST);
            }
        }
        else {
            if (game.getScoreAway() == game.getScoreHome()) {
                bet.setStatus(BetStatus.WON);
            }
            else {
                bet.setStatus(BetStatus.LOST);
            }
        }

        return bet;
    }

}
