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

    static Settings getInstance() {
        if (instance == null) {
            instance = new Settings(new Translation(), new GameParameters());
        }
        return instance;
    }

    String getGameParameter(String parameter) {
        return parameters.get(parameter);
    }
}
