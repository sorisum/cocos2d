package org.cocos2d.transitions;

import org.cocos2d.actions.instant.CCCallFunc;
import org.cocos2d.actions.interval.CCFadeIn;
import org.cocos2d.actions.interval.CCFadeOut;
import org.cocos2d.actions.interval.CCIntervalAction;
import org.cocos2d.actions.interval.CCSequence;
import org.cocos2d.layers.CCColorLayer;
import org.cocos2d.nodes.CCNode;
import org.cocos2d.nodes.Scene;
import org.cocos2d.types.ccColor3B;
import org.cocos2d.types.ccColor4B;

/**
 * Fade Transition.
 * Fade out the outgoing scene and then fade in the incoming scene.
 */
public class FadeTransition extends TransitionScene {
    ccColor4B RGBA;

    /**
     * creates the transition with a duration and with an RGB color
     */
    public static FadeTransition transition(float t, Scene s, ccColor3B rgb) {
        return new FadeTransition(t, s, rgb);
    }

    /**
     * initializes the transition with a duration and with an RGB color
     */
    public FadeTransition(float d, Scene s, ccColor3B rgb) {
        super(d, s);
        RGBA = new ccColor4B(rgb.r, rgb.g, rgb.b, 0);
    }

    /**
     * initializes the transition with a duration
     */
    public FadeTransition(float d, Scene s) {
        this(d, s, new ccColor3B(0, 0, 0));
    }

    public void onEnter() {
        super.onEnter();

        CCColorLayer l = CCColorLayer.node(RGBA);
        inScene.setVisible(false);

        addChild(l, 2, kSceneFade);


        CCNode f = getChild(kSceneFade);

        CCIntervalAction a = CCSequence.actions(
                CCFadeIn.action(duration / 2),
                CCCallFunc.action(this, "hideOutShowIn"),
                CCFadeOut.action(duration / 2),
                CCCallFunc.action(this, "finish"));
        f.runAction(a);
    }

    public void onExit() {
        super.onExit();
        removeChild(kSceneFade, false);
    }

}
