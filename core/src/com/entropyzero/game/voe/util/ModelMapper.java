package com.entropyzero.game.voe.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;

import java.util.Objects;

public interface ModelMapper {

    Json JSON = new Json();

    record Binding(String name, Class<?> type) { }

    static Binding bind(String name, Class<?> type) {
        return new Binding(name, type);
    }

    /**
     * <p>Usage example</p>
     * <code>
     *         SkillHolder sh = ModelMapper.toModel("model/skill.json",
     *                 ModelMapper.bind("list", SkillHolder.class),
     *                 ModelMapper.bind("skill", Skill.class)
     *         );
     * </code>
     */
    static <T> T toModel(String path, Binding parentBinding, Binding... childBindings) {
        Objects.requireNonNull(parentBinding, "No parent binding provided");
        for(Binding b : childBindings) {
            JSON.addClassTag(b.name, b.type);
        }
        Class<T> targetType = (Class<T>) parentBinding.type;
        return JSON.fromJson(targetType, Gdx.files.internal(path));
    }
}
