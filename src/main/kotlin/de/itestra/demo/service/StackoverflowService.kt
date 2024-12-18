package de.itestra.demo.service

import com.intellij.ide.BrowserUtil
import com.intellij.openapi.components.Service
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Service
class StackoverflowService(private val cs: CoroutineScope) {

    fun searchStackoverflow(editor: Editor?, psiFile: PsiFile?) {
        cs.launch {
            // Add Thread.sleep(2000) to actionPerformed in class SearchStackoverflowAction and observe, how the UI
            // will not respond for 2 seconds.
            // If you add a delay here in the coroutine, it won't affect the UI of the IDE.
            // delay(2000)
            // Feel free to play around with it
            val language = psiFile?.language
            val languageTag = "+[" + language?.displayName?.lowercase() + "]"
            val currentCaret = editor?.caretModel?.currentCaret
            val selectedText = currentCaret?.selectedText
            val query = selectedText?.replace(' ', '+') + languageTag
            BrowserUtil.browse("https:stackoverflow.com/search?q=$query")
        }
    }
}