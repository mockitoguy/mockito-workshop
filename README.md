Workshop prerequisites:

# jdk 1.6 installed
# eclipse or idea installed
# git installed

Workshop instructions:

# git clone http://github.com/szczepiq/mockito-workshop.git
## alternatively, if don't have git, download (1.5 MB): https://github.com/szczepiq/mockito-workshop/zipball/master
# Import the project into your favorite IDE (that is: eclipse or IntelliJ :)
# Make sure the project builds & compiles in your IDE
# The instructor will start live-coding the exercises, please follow

Below stories are more like 'notes'. Once we get to work on the together things will get clear :)

Workshop stories. SmartDictionary:

#. delegates to Translator for translations. Start by adding "shouldLookUpWords" test.
#. "Only mock types you own", create Translator implementation that wraps the OnlineTranslator
#. remembers the translation input and translation result via the History. Start by adding "shouldRememberTranslationAttempts" test.
#. Use test constructor for 'boring' setup
#. Use @Mock, @InjectMocks annotations and the MocktioJUnitRunner

#. If History throws CannotUpdateHistory runtime exception. SmartDictionary should just warn in such case and not fail explosively. Start by adding "shouldIgnoreUnavailableHistory" test.
#. What's the alternative implementations of that feature?

#. Modeling: use TranslationRequest in Translator
##. Implement equals() to facilitate argument matching
##. The problem of 2 failing tests when translation feature is broken.
##. Use argument matcher
##. Argument matcher can be used for stubbing or verification

#. More Modeling: use TranslationResult in Translator
##. History should remember the TranslationResult
##. Use argument matcher
##. Demonstrate usefulness of toString() when arg matching fails
##. Use argument captor
##. What's the alternative apart from matcher, captor and equals() ?
##. Use relaxed arg matching to improve tests maintainability

#. Store the current date with TranslationRequest. Explain the effect on the equals(). Demonstrate the usefulness of the arg matcher

#. Retry the translation attempts up to X times. Start with "shouldRetryTranslations" test.
##. Model RetryingTranslator and move the unit tests accordingly
##. Use RetryingTranslator directly in SmartDictionary and show that all tests still pass
##. Don't forget about happy and unhappy tests for the feature

#. Break TranslationHistory operation into 2: translation attempt and translation completed. Start with "shouldTrackTranslationAttempts" test for the RetryingTranslatorTest
##. Explain the kinds of verification modes (atLeastOnce(), atLeast, atMost, never())
##. What do we do with the CannotUpdateHistory? Create SafeHistory implementation and move tests accordingly
##. Explain verifyZeroInteractions and ignoreStubs()

#. Demonstrate all tests work if SmartDictionary uses the RetryingTranslator and SafeHistory directly. Is it a good idea?
#. Introduce dictionary factory - you dependency injection infrastructure

#. Only use TranslationHistory if the keepHistory is enabled for SmartDictionary. Start with "shouldHistoryUpdatesBeConfigurable" test for SafeHistoryTest.
##. Use never() to make sure the interactions didn't happen
##. Refactor to use verifyNoMoreInteractions()

#. TranslationResult contains the TranslationRequest
##. Fail immediately if returned TranslationResult does not have sent in TranslationRequest.
##. Refactor to a separate object: ValidatingTranslator

#. Refactor to separate packages: api, history, translators