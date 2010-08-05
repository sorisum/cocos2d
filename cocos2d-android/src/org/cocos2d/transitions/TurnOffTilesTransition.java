package org.cocos2d.transitions;

import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.Scene;
import org.cocos2d.types.CGSize;
import org.cocos2d.actions.interval.CCIntervalAction;
import org.cocos2d.actions.ease.CCEaseOut;

/**
 * TurnOffTiles Transition.
 * Turn off the tiles of the outgoing scene in random order
 */
public class TurnOffTilesTransition extends TransitionScene {
    
    public static TransitionScene transition(float t, Scene s) {
        return new TurnOffTilesTransition(t, s);
    }

    public TurnOffTilesTransition(float t, Scene s) {
        super(t, s);
    }

    // override addScenes, and change the order
    public void sceneOrder()
    {
        inSceneOnTop = false;
    }

    public void onEnter() {
        super.onEnter();

        CGSize s = CCDirector.sharedDirector().winSize();
        // float aspect = s.width / s.height;
        // int x = (int) (12 * aspect);
        // int y = 12;

//        Action toff = TurnOffTiles.action(CCGridSize.ccg(x,y), duration);
//        outScene.runAction(Sequence.actions(toff,
//                           new CallFunc(this, new CCSelector(this, "finish")),
//                           StopGrid.action()));

    }

    protected CCIntervalAction easeAction(CCIntervalAction action) {
        return action;
//        return EaseOut.action(action, 2.0f);
    }
    
}
