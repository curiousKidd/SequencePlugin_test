package vanstudio.sequence;

import com.intellij.psi.PsiElement;

/**
 * &copy; fanhuagang@gmail.com
 * Created by van on 2020/2/23.
 */
public interface SequenceService {
    String PLUGIN_ID = "SequenceDiagramGW";
    String PLUGIN_NAME = "Sequence Diagram GW";

    void showSequence(PsiElement psiElement);

}
