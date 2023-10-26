package com.example.euroleaguewordle.service.impl;

import com.example.euroleaguewordle.model.Player;
import com.example.euroleaguewordle.model.Team;
import com.example.euroleaguewordle.model.dto.AnswerDto;
import com.example.euroleaguewordle.model.dto.GetNamesDto;
import com.example.euroleaguewordle.model.dto.GetPlayerDto;
import com.example.euroleaguewordle.model.dto.SavePlayerDto;
import com.example.euroleaguewordle.model.enums.Answer;
import com.example.euroleaguewordle.model.exceptions.PlayerNotFoundException;
import com.example.euroleaguewordle.model.exceptions.TeamNotFoundException;
import com.example.euroleaguewordle.repository.PlayerRepository;
import com.example.euroleaguewordle.repository.TeamRepository;
import com.example.euroleaguewordle.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.euroleaguewordle.EuroleagueWordleApplication.randomNum;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    @Override
    public GetPlayerDto getGuessedPlayer(Long playerId) {
        Player player = this.playerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException(playerId));

        LocalDate today = LocalDate.now();

        if (Period.between(player.getDateOfBirth(), today).getYears() != player.getAge()) {
            player.setAge(Period.between(player.getDateOfBirth(), today).getYears());
            this.playerRepository.save(player);
        }

        GetPlayerDto getPlayerDto = new GetPlayerDto();

        getPlayerDto.setId(player.getId());
        getPlayerDto.setImage(player.getImage());
        getPlayerDto.setAge(player.getAge());
        getPlayerDto.setHeight(player.getHeight());
        getPlayerDto.setName(player.getName());
        getPlayerDto.setNationality(player.getNationality());
        getPlayerDto.setPosition(player.getPosition());
        getPlayerDto.setTeamImage(player.getTeamImage());
        getPlayerDto.setTeamId(player.getTeamId());
        getPlayerDto.setJerseyNumber(player.getJerseyNumber());

        return getPlayerDto;
    }

    @Override
    public Player findById(Long playerId) {
        return this.playerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException(playerId));
    }

    @Override
    public List<Player> findAll() {
        return this.playerRepository.findAll();
    }

    @Override
    public Player add(SavePlayerDto savePlayerDto) {
        Player addPlayer = new Player();

        addPlayer.setName(savePlayerDto.getName());
        addPlayer.setAge(savePlayerDto.getAge());
        addPlayer.setPosition(savePlayerDto.getPosition());
        addPlayer.setJerseyNumber(savePlayerDto.getJerseyNumber());
        addPlayer.setHeight(savePlayerDto.getHeight());
        addPlayer.setTeamId(savePlayerDto.getTeamId());
        addPlayer.setNationality(savePlayerDto.getNationality());
        addPlayer.setImage(savePlayerDto.getImage());
        Team team = teamRepository.findById(addPlayer.getTeamId())
                .orElseThrow(() -> new TeamNotFoundException(addPlayer.getTeamId()));
        addPlayer.setTeamImage(team.getImage());
        this.playerRepository.save(addPlayer);

        return addPlayer;
    }

    @Override
    public AnswerDto comparePlayers(Long playerId) {
        List<Answer> answers = new ArrayList<>();
        AnswerDto answerDto = new AnswerDto();
        Player wordle = this.findById((long) randomNum);
        Player guess = this.playerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException(playerId));

        LocalDate today = LocalDate.now();
        if (Period.between(wordle.getDateOfBirth(), today).getYears() != wordle.getAge()) {
            wordle.setAge(Period.between(wordle.getDateOfBirth(), today).getYears());
            this.playerRepository.save(wordle);
        }

        if (Period.between(guess.getDateOfBirth(), today).getYears() != guess.getAge()) {
            guess.setAge(Period.between(guess.getDateOfBirth(), today).getYears());
            this.playerRepository.save(guess);
        }


        if (guess.equals(wordle)) {
            answerDto.setName(Answer.CORRECT);
            answerDto.setAge(Answer.CORRECT);
            answerDto.setHeight(Answer.CORRECT);
            answerDto.setNationality(Answer.CORRECT);
            answerDto.setPosition(Answer.CORRECT);
            answerDto.setJerseyNumber(Answer.CORRECT);
            answerDto.setTeamId(Answer.CORRECT);

            return answerDto;
        }
        else {
            if(guess.getName().equals(wordle.getName()))
                answerDto.setName(Answer.CORRECT);
            else
                answerDto.setName(Answer.WRONG);

            if (Objects.equals(guess.getTeamId(), wordle.getTeamId()))
                answerDto.setTeamId(Answer.CORRECT);
            else
                answerDto.setTeamId(Answer.WRONG);

            if (guess.getPosition().equals(wordle.getPosition()))
                answerDto.setPosition(Answer.CORRECT);
            else
                answerDto.setPosition(Answer.WRONG);

            if (guess.getNationality().equals(wordle.getNationality()))
                answerDto.setNationality(Answer.CORRECT);
            else answerDto.setNationality(Answer.WRONG);

            if (guess.getHeight() == wordle.getHeight())
                answerDto.setHeight(Answer.CORRECT);
            else {
                if (guess.getHeight() > wordle.getHeight() && guess.getHeight() - wordle.getHeight() <= 3)
                    answerDto.setHeight(Answer.DOWN);
                else if (guess.getHeight() < wordle.getHeight() &&  wordle.getHeight() - guess.getHeight() <= 3)
                    answerDto.setHeight(Answer.UP);
                else if (guess.getHeight() > wordle.getHeight() && guess.getHeight() - wordle.getHeight() > 3)
                    answerDto.setHeight(Answer.WRONGDOWN);
                else
                    answerDto.setHeight(Answer.WRONGUP);
            }

            if (guess.getJerseyNumber() == wordle.getJerseyNumber())
                answerDto.setJerseyNumber(Answer.CORRECT);
            else {
                if (guess.getJerseyNumber() < wordle.getJerseyNumber() && wordle.getJerseyNumber() - guess.getJerseyNumber() <= 3)
                    answerDto.setJerseyNumber(Answer.UP);
                else if (guess.getJerseyNumber() > wordle.getJerseyNumber() &&  guess.getJerseyNumber() - wordle.getJerseyNumber() <= 3)
                    answerDto.setJerseyNumber(Answer.DOWN);
                else if (guess.getJerseyNumber() < wordle.getJerseyNumber() && wordle.getJerseyNumber() - guess.getJerseyNumber() > 3)
                    answerDto.setJerseyNumber(Answer.WRONGUP);
                else
                    answerDto.setJerseyNumber(Answer.WRONGDOWN);
            }

            if (guess.getAge() == wordle.getAge())
                answerDto.setAge(Answer.CORRECT);
            else {
                if (guess.getAge() < wordle.getAge() && wordle.getAge() - guess.getAge() <= 3)
                    answerDto.setAge(Answer.UP);
                else if (guess.getAge() > wordle.getAge() && guess.getAge() - wordle.getAge() <= 3)
                    answerDto.setAge(Answer.DOWN);
                else if (guess.getAge() < wordle.getAge() && wordle.getAge() - guess.getAge() > 3)
                    answerDto.setAge(Answer.WRONGUP);
                else
                    answerDto.setAge(Answer.WRONGDOWN);
            }
        }

        return answerDto;
    }

    @Override
    public Player findByName(String name) {
        return this.playerRepository.getPlayerByName(name);
    }

    @Override
    public List<GetNamesDto> findAllNames() {
        List<Player> players = this.playerRepository.findAll();
        List<GetNamesDto> names = new ArrayList<>();
        for (Player player : players) {
            GetNamesDto getNamesDto = new GetNamesDto();
            getNamesDto.setLabel(player.getName());
            getNamesDto.setValue(player.getId());
            names.add(getNamesDto);
        }

        return names;
    }

    @Override
    public Player getWordlePlayer() {
        return this.playerRepository.findById((long) randomNum)
                .orElseThrow(() -> new PlayerNotFoundException((long) randomNum));
    }
}
