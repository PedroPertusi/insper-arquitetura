package com.insper.partida.aposta;

import com.insper.partida.equipe.Team;
import com.insper.partida.game.Game;
import com.insper.partida.game.GameService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class BetServiceTests {

    @InjectMocks
    BetService betService;

    @Mock
    BetRespository betRespository;


    @Mock
    GameService gameService;


    @Test
    void test_saveBet() {
        Team team = new Team();
        team.setId(1);
        team.setIdentifier("time-1");

        Team team2 = new Team();
        team2.setId(2);
        team2.setIdentifier("time-2");

        Game game = new Game();
        game.setHome(team);
        game.setAway(team2);
        game.setIdentifier("game-1");

        Bet bet = new Bet();
        bet.setId(1);
        bet.setGame(game);
        bet.setStatus(BetStatus.WON);
        bet.setResult(BetResult.AWAY);

        Mockito.when(gameService.getGame(game.getIdentifier())).thenReturn(game);
        Mockito.when(betRespository.save(bet)).thenReturn(bet);
        Bet resp = betService.saveBet(bet);

        Assertions.assertEquals(1, resp.getId());
        Assertions.assertEquals(game, resp.getGame());
        Assertions.assertEquals(BetResult.AWAY, resp.getResult());
        Assertions.assertEquals(BetStatus.WON, resp.getStatus());
    }


    @Test
    void test_listBets() {

        Bet bet = new Bet();
        bet.setResult(BetResult.HOME);
        bet.setStatus(BetStatus.WON);

        List<Bet> bets = new ArrayList<>();
        bets.add(bet);

        Mockito.when(betRespository.findAll()).thenReturn(bets);

        List<Bet> resp = betService.listBets();

        Assertions.assertEquals(1, resp.size());
        Assertions.assertEquals(BetResult.HOME, resp.get(0).getResult());
    }

    @Test
    void test_verifyBet() {
        Team team = new Team();
        team.setId(1);
        team.setIdentifier("time-1");

        Team team2 = new Team();
        team2.setId(2);
        team2.setIdentifier("time-2");

        Game game = new Game();
        game.setHome(team);
        game.setAway(team2);
        game.setIdentifier("game-1");
        game.setScoreHome(1);
        game.setScoreAway(0);

        Bet bet = new Bet();
        bet.setResult(BetResult.HOME);
        bet.setGame(game);

        Mockito.when(betRespository.findById(1)).thenReturn(Optional.of(bet));

        Bet resp = betService.verifyBet(1);

        Assertions.assertEquals(BetStatus.WON, resp.getStatus());
    }


}
