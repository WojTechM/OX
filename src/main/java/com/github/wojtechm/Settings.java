package com.github.wojtechm;

/**
 * @author Makiela Wojciech
 */
class Settings {

    private static Settings instance = null;

    private Translation translation;
    private GameParameters parameters;

    private Settings(Translation translation, GameParameters parameters) {
        this.translation = translation;
        this.parameters = parameters;
    }

    void setTranslation(Translation translation) {
        this.translation = translation;
    }

    static Settings getInstance() {
        if (instance == null) {
            instance = new Settings(new Translation(null), new GameParameters());
        }
        return instance;
    }

    String getGameParameter(String parameter) {
        return parameters.get(parameter);
    }

    String getMessage(String message) {
        return translation.getMessage(message);
    }

    void setGameParameter(String parameter, String newValue) {
        this.parameters.set(parameter, newValue);
    }

    String[] gameParameters() {
        String[] parameters = new String[5];
        parameters[0] = this.parameters.get("boardWidth");
        parameters[1] = this.parameters.get("boardHeight");
        parameters[2] = this.parameters.get("inlineMatches");
        parameters[3] = this.parameters.get("numberOfRounds");
        parameters[4] = this.parameters.get("translation");
        return parameters;
    }
}
